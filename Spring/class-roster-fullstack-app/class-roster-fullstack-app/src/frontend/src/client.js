import unfetch from 'unfetch';

const checkStatus = (response) => {
    if (response.ok) {
        return response;
    }
    // convert non-2xx HTTP responses into errors:
    const error = new Error(response.statusText);
    error.response = response;
    return Promise.reject(error);
}

export const getAllStudents = () => {
    return unfetch("/api/v1/students")
           .then(checkStatus);
}

export const createAStudent = student => {
    return unfetch("/api/v1/students", {
        headers: {
            'Content-Type':'application/json'
        },
        method: 'POST',
        body: JSON.stringify(student)
    }).then(checkStatus);
}

export const deleteAStudent = id => {
    return unfetch("/api/v1/students/" + id, {
        method: 'DELETE'
    }).then(checkStatus);
}

export const editAStudent = (student) => {
    return unfetch("/api/v1/students/edit", {
        headers: {
            'Content-Type':'application/json'
        },
        method: 'PUT',
        body: JSON.stringify(student)
    }).then(checkStatus);
}

export const getAStudentById = (id) => {
    return unfetch("/api/v1/students/" + id)
        .then(checkStatus);
}