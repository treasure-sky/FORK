// import React,{useReducer, useRef, useCallback} from 'react';
import React, {useState} from 'react';
import {Route, Routes} from 'react-router-dom';
import Main from '../src/pages/Main'
import ResultPage from './pages/ResultPage'
import axios from 'axios';

const App =()=> {
  const [data, setData] = useState(null);
  // const onClick = async()=>{
  //   try{
  //     const response = await axios.get(...);
  //     setData(response.data);
  //   } catch(e){
  //     console.log(e);
  //   }
  // };

  return (
    <div className='App'>
      <Routes>
        <Route path="/" element={<Main/>}/>
        <Route path="/result" element={<ResultPage/>}/>
      </Routes>
    </div>
  )
}
export default App;