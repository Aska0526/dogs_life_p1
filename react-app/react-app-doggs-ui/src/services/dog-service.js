import http from './axios-common'

export function getAllDogs(){
    console.log("backend called")
    return http.get('/dogs');
}

export function getNoOfDogs(){
    return http.get('dogs/count');
}

