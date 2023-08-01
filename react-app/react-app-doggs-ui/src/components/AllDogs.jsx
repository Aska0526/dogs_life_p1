import React, { useEffect, useState } from 'react'
import DogDetail from './DogDetail'
import { getAllDogs, getNoOfDogs } from '../services/dog-service';
import { Row } from 'react-bootstrap';
const AllDogs = () => {


    const [dogs, setDogs] = useState([]);
    const [dogCount, setDogCount] = useState(0);

    useEffect(() => {
        getDogsFromAPI();
        getNoOfDogsFromAPI();
    }, []);

    const getDogsFromAPI = () => {
        getAllDogs()
            .then(res => {
                setDogs(res.data);
            })
            .catch(err => {
                setDogs([]);
                console.log(err);
            })

    };

    const getNoOfDogsFromAPI = () => {
        getNoOfDogs()
            .then(res => {
                setDogCount(res.data);
            })
            .catch(err => {
                setDogCount(0);
                console.log(err);
            })
    }

    return (
        <>
         <h1>Total count of dogs is: {dogCount}</h1>
        <Row>
            {dogs.map(dog => (
                <div key={dog.id.toString()}>
                    <DogDetail info={dog}/>
                </div>
            ))}
        </Row>
       
        
        </>
    )
}

export default AllDogs