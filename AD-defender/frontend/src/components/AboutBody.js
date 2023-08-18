import '../styles/AboutBody.scss';
import {React} from "react";
const AboutBody = (props) => {
    return(
        <div className='wrapper'>
            <div className="about-section">
                <div className="container">
                    <div className='about-title'>
                        <h1>스물셋</h1>
                    </div>
                    <div className='about-in'>
                        <hr/>
                        <h3>스물세살 네명이, <br/>
                            디지털 격차를 해결 하기 위해 모였다!</h3>
                    </div>
                    <div className='about-row'>
                        <div className='about-col'>
                            <div className='profile-img'>
                                <img src='image/profile01.png' />
                            </div>
                            <h4>허태웅</h4>
                            <ul>
                                <li><a>2001.05.31</a></li>
                                <li><a>전기전자공학과</a></li>
                                <li><a>ENTJ</a></li>
                                <li><a>Front&BackEnd</a></li>
                            </ul>
                        </div>
                        <div className='about-col'>
                            <div className='profile-img'>
                                <img src='image/profile02.png' />
                            </div>
                            <h4>이진호 </h4>
                            <ul>
                                <li><a>2001.08.18</a></li>
                                <li><a>컴퓨터공학과</a></li>
                                <li><a>INTJ</a></li>
                                <li><a>BackEnd</a></li>
                            </ul>
                        </div>
                        <div className='about-col'>
                            <div className='profile-img'>
                                <img src='image/profile03.png' />
                            </div>
                            <h4>유다인</h4>
                            <ul>
                                <li><a>2001.05.21</a></li>
                                <li><a>컴퓨터공학과</a></li>
                                <li><a>INFJ</a></li>
                                <li><a>BackEnd</a></li>
                            </ul>
                        </div>
                        <div className='about-col'>
                            <div className='profile-img'>
                                <img src='image/profile04.png' />
                            </div>
                            <h4>이예지</h4>
                            <ul>
                                <li><a>2001.04.21</a></li>
                                <li><a>컴퓨터공학과</a></li>
                                <li><a>ENFJ</a></li>
                                <li><a>FrontEnd</a></li>
                            </ul>
                        </div>


                    </div>

                </div>
            </div>
        </div>
    )
}

export default AboutBody;
