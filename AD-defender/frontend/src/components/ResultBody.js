import { useState, useEffect } from 'react';
import './ResultBody.scss';
import HeartButton from './HeartButton';
// import LinkResult from './LinkResult';
import axios from 'axios';

const BodyRes = (props) =>{
    const [isCommercial, setCommercial] = useState('');
    const [like, setLike] = useState('');
    //useEffect 안에서 axios를 통해 사용자가 좋아요 눌렀는지, 여부 판단
    //결과는 type이라는 변수에 담음.
    // useEffect(async() => {
    //     const fetchData = async () => {
    //         // const res = await axios.get(...) 
    //         // if (res.data.type === 'liked') setLike(true)
    //     }
    //     fetchData()
    // }, []);
    //toggle 함수: 사용자가 좋아요 눌렀을 때 POST 요청 통해 DB 갱신,
    //toggle 형태로 like의 상태를 바꾸는(true or false) 역할  
    // const toggleLike = async (e) => {
    //     // const res = await axios.post(...) //사용자 좋아요 누르면 -> DB 갱신
    //     setLike(!like)
    // }
    return(
        <div className='body'>
            <div className='link-section'>
                <h2>https://</h2>
            </div>
            {/* <LinkResult/> */}
            {/* <HeartButton like={like} onClick={toggleLike}/> */}
        </div>
    )
}

export default BodyRes;