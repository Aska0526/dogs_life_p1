import http from './axios-common'

export function getAllDogs(){
    return http.get('/dogs');
}

export function getNoOfDogs(){
    return http.get('dogs/count');
}

