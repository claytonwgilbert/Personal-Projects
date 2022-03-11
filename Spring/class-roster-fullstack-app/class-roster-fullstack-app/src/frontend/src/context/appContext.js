import React, { useEffect, useContext, useReducer } from 'react'
import reducer from '../reducers/appReducer'
import {getAllStudents, deleteAStudent, getAStudentById, editAStudent, createAStudent} from "../client";

/*const getLocalStorage = () => {
    let students = localStorage.getItem('students')
    if(students !== false){
        return JSON.parse(localStorage.getItem('students'))
    }
    else{
        return []
    }
}*/

const initialState = {
    students: [],
    studentToEdit: {},
    isCollapsed: false,
    isLoading: false,
    showDrawer: false,
    showEditDrawer: false,
    isSubmitting: false,
    createdStudentsCount: 0,
    editedStudentsCount: 0,
    deletedStudentsCount: 0,
};

const AppContext = React.createContext({});

export const AppProvider = ({ children }) => {
    const [state, dispatch] = useReducer(reducer, initialState)

    useEffect(() => {
        fetchStudents();
        //localStorage.setItem('students',JSON.stringify(state.students))
    }, [state.createdStudentsCount, state.editedStudentsCount, state.deletedStudentsCount])

    const fetchStudents = () => {
        dispatch({ type: "GET_ALL_STUDENTS_BEGIN" })
        getAllStudents()
            .then(res => res.json())
            .then(data => {
                dispatch({
                    type: "GET_ALL_STUDENTS_SUCCESS",
                    payload: data,
                })
            }).catch(err => {
                dispatch({
                    type: "GET_ALL_STUDENTS_ERROR",
                    payload: err,
                })
        }).finally(() => {
            dispatch({ type: "GET_ALL_STUDENTS_FINISHED" })
        })
    }

    const createNewStudent = (student) => {
        dispatch({ type: "CREATE_STUDENT_BEGIN" })
        createAStudent(student).then(() => {
            dispatch({type: "CREATE_STUDENT_SUCCESS", payload: student.name})
        }).catch(err => {
            err.response.json().then(res => {
                dispatch({type: "CREATE_STUDENT_ERROR", payload: res})
            })
        });
        dispatch({ type: "CREATE_STUDENT_FINISHED", payload: state.createdStudentsCount })
    }

    const createNewStudentFailed = () => {
        closeDrawer();
    }

    const editStudent = (student) => {
        student.id = +state.studentToEdit.id;
        console.log(student);
        dispatch({ type: "EDIT_STUDENT_BEGIN" })
        editAStudent(student).then(() => {
            dispatch({type: "EDIT_STUDENT_SUCCESS", payload: state.studentToEdit.id})
        }).catch(err => {
            err.response.json().then(res => {
                console.log(res);
                dispatch({type: "EDIT_STUDENT_ERROR", payload: res})
            })
        });
        dispatch({ type: "EDIT_STUDENT_FINISHED", payload: state.editedStudentsCount })
    }

    const editStudentFailed = () => {
        closeEditDrawer();
    }

    const deleteStudent = (studentId) => {
        deleteAStudent(studentId).then(() => {
            dispatch({type: "DELETE_STUDENT_SUCCESS", payload: studentId})
        }).catch(err => {
            err.response.json().then(res => {
                dispatch({type: "DELETE_STUDENT_ERROR", payload: res})
            })
        }).finally(() => {
            dispatch({type: "DELETE_STUDENT_FINISHED"})
        });
    }

    const openDrawer = () => {
        dispatch({ type: "OPEN_DRAWER" })
    }

    const closeDrawer = () => {
        dispatch({ type: "CLOSE_DRAWER" })
    }

    const openEditDrawer = (studentId) => {
        getAStudentById(studentId).then(res => res.json()).then(student => {
            console.log(student);
            dispatch({type: "GET_STUDENT_TO_EDIT_SUCCESS", payload: student})
        }).catch(err => {
            err.response.json().then(res => {
                dispatch({type: "GET_STUDENT_TO_EDIT_ERROR", payload: res})
            })
        }).finally(() => {
            dispatch({ type: "OPEN_EDIT_DRAWER" })
        });
    }

    const closeEditDrawer = () => {
        dispatch({ type: "CLOSE_EDIT_DRAWER" })
    }

    const toggleSubmittingOn = () => {
        dispatch({ type: "TOGGLE_SUBMITTING_ON" })
    }

    const toggleSubmittingOff = () => {
        dispatch({ type: "TOGGLE_SUBMITTING_OFF" })
    }

    const toggleSider = () => {
        dispatch({ type: "TOGGLE_SIDER" })
    }

    const cancelConfirm = () => {
        dispatch({ type: "CANCEL_CONFIRM" })
    }

    return (
        <AppContext.Provider value={{...state,
            fetchStudents,
            openDrawer,
            closeDrawer,
            openEditDrawer,
            closeEditDrawer,
            createNewStudent,
            createNewStudentFailed,
            toggleSubmittingOff,
            toggleSubmittingOn,
            editStudent,
            editStudentFailed,
            toggleSider,
            deleteStudent,
            cancelConfirm
        }}>{children}</AppContext.Provider>
    )
}
// make sure use
export const useAppContext = () => {
    return useContext(AppContext)
}