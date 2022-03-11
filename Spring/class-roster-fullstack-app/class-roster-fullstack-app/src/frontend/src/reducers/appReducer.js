import {errorNotification, successNotification} from "../Notification";

const appReducer = (state, action) => {
    if(action.type === "GET_ALL_STUDENTS_BEGIN"){
        return {
            ...state,
            isLoading: true,
        }
    }

    if(action.type === "GET_ALL_STUDENTS_SUCCESS"){
        return {
            ...state,
            students: action.payload,
        }
    }

    if(action.type === "GET_ALL_STUDENTS_ERROR"){
        errorNotification("There was a problem...", `${action.payload.message()}[${action.payload.status}][${action.payload.error}]`)
        return {
            ...state,
        }
    }

    if(action.type === "GET_ALL_STUDENTS_FINISHED"){
        return {
            ...state,
            isLoading: false,
        }
    }

    if(action.type === "CREATE_STUDENT_BEGIN"){
        return {
            ...state,
            isLoading: true,
        }
    }

    if(action.type === "CREATE_STUDENT_SUCCESS"){
        successNotification('Student created successfully', `${action.payload} wad created successfully.`);
        return {
            ...state,
        }
    }

    if(action.type === "CREATE_STUDENT_ERROR"){
        errorNotification("There was a problem...", `${action.payload.message()}[${action.payload.status}][${action.payload.error}]`)
        return {
            ...state,
        }
    }

    if(action.type === "CREATE_STUDENT_FINISHED"){
        return {
            ...state,
            isLoading: false,
            showDrawer: false,
            createdStudentsCount: state.createdStudentsCount + 1,
        }
    }

    if(action.type === "EDIT_STUDENT_BEGIN"){
        return {
            ...state,
            isSubmitting: true,
        }
    }

    if(action.type === "EDIT_STUDENT_SUCCESS"){
        successNotification('Student edited successfully', `Student with id of ${action.payload} wad edited successfully.`);
        return {
            ...state,
        }
    }

    if(action.type === "EDIT_STUDENT_ERROR"){
        errorNotification("There was a problem...", `${action.payload.message()}[${action.payload.status}][${action.payload.error}]`)
        return {
            ...state,
        }
    }

    if(action.type === "EDIT_STUDENT_FINISHED"){
        return {
            ...state,
            isSubmitting: false,
            showEditDrawer: false,
            editedStudentsCount: state.editedStudentsCount + 1,
        }
    }

    if(action.type === "DELETE_STUDENT_SUCCESS"){
        successNotification('Student deleted successfully', `Student with id of ${action.payload} wad deleted successfully`);
        return {
            ...state
        }
    }

    if(action.type === "DELETE_STUDENT_FINISHED"){
        return {
            ...state,
            deletedStudentsCount: state.deletedStudentsCount + 1,
        }
    }


    if(action.type === "DELETE_STUDENT_ERROR"){
        errorNotification("There was a problem...", `${action.payload.message()}[${action.payload.status}][${action.payload.error}]`)
        return {
            ...state
        }
    }

    if(action.type === "OPEN_DRAWER"){
        return {
            ...state,
            showDrawer: true,
        }
    }

    if(action.type === "CLOSE_DRAWER"){
        return {
            ...state,
            showDrawer: false,
        }
    }

    if(action.type === "OPEN_EDIT_DRAWER"){
        console.log(state.studentToEdit);
        return {
            ...state,
            showEditDrawer: true,
        }
    }

    if(action.type === "CLOSE_EDIT_DRAWER"){
        return {
            ...state,
            showEditDrawer: false,
        }
    }

    if(action.type === "GET_STUDENT_TO_EDIT_SUCCESS"){
        console.log(action.payload);
        return {
            ...state,
            studentToEdit: action.payload,
        }
    }

    if(action.type === "GET_STUDENT_TO_EDIT_ERROR"){
        errorNotification("There was a problem...", `${action.payload.message()}[${action.payload.status}][${action.payload.error}]`)
        return {
            ...state,
            showEditDrawer: false,
        }
    }

    if(action.type === "TOGGLE_SUBMITTING_ON"){
        return {
            ...state,
            isSubmitting: true,
        }
    }

    if(action.type === "TOGGLE_SUBMITTING_OFF"){
        return {
            ...state,
            isSubmitting: false,
        }
    }

    if(action.type === "TOGGLE_SIDER"){
        return {
            ...state,
            isCollapsed: !state.isCollapsed,
        }
    }

    if(action.type === "CANCEL_CONFIRM"){
        return {
            ...state,
        }
    }
}
export default appReducer;