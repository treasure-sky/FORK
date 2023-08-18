import { useState, useEffect } from 'react';
import '../styles/ResultBody.scss';
import { useLocation, Link } from 'react-router-dom';
import LinkResult from "./LinkResult";

const BodyRes = (props) =>{
    const location = useLocation(); // 현재 라우팅 정보 가져오기
    const chatResponse = location.state ? location.state.chatResponse : '';
    const [result, setResult] = useState(true); //true면 광고
    const resultText = chatResponse.choices[0].message.content;
    const inputUrl = chatResponse.url;
    useEffect(() => {
        if(resultText=="아니요") {
            setResult(false);
        }
    }, []);

    console.dir(chatResponse);
    return(
        <div className='body'>
            <div className='link-section'>
                <h2>{inputUrl}</h2>
            </div>
            <div className='result'>
                <LinkResult isCommercial={result}/>
            </div>
            <Link to="/"><button className='w-btn w-btn-gra1 w-btn-gra-anim'>
                <h3>홈 화면으로 돌아가기</h3>
            </button> </Link>

            {/* <HeartButton like={like} onClick={toggleLike}/> */}
        </div>
    )
}
export default BodyRes;