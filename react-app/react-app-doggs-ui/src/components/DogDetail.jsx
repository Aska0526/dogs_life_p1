import React from 'react'
import { useState } from 'react';

const DogDetail = (props) => {
  const[ownerCheck,setOwnerCheck] = useState(0);

  const seeOwner = () =>{
    setOwnerCheck(1-ownerCheck);
  }
  return (
    <div>
        <p>Dog name: {props.info.name}</p>
        <p>Age: {props.info.age} </p>
        <button onClick={seeOwner}> Show owner</button>
        <p>ownerCheck === 1 && OwnerName: {props.info.owner.name} </p>
    </div>
  )
}

export default DogDetail