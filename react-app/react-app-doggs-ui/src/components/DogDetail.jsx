import React from 'react'

const DogDetail = (props) => {
  const[ownerCheck,setOwnerCheck] = useState(0);
  const seeOwner = () =>{
    setOwnerCheck(ownerCheck+1);
  }
  return (
    <div>
        <p>Dog name: {props.info.name}</p>
        <p>Age: {props.info.age} </p>
        <button onClick={showOwner}> Show owner</button>
    </div>
  )
}

export default DogDetail