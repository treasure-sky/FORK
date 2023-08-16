import '../styles/Footer.scss';
import {React} from 'react';
import {FaInstagram} from 'react-icons/fa';


function Footer(props){
    return(
        <div className='wrap'>
            <div className='footer'>
                <div className='container'>
                    <div className='row'>
                        <div className='footer-col'>
                            <h4>This page is</h4>
                            <ul>
                                <li><a>@copyright2023 ForK</a></li>
                            </ul>
                        </div>
                        <div className='footer-col'>
                            <h4>About us</h4>
                            <ul>
                                <li><a>likeLion KNU</a></li>
                                <li><a>Team 'TwentyThree'</a></li>
                            </ul>
                        </div>
                        <div className='footer-col'>
                            <h4>Members</h4>
                            <ul>
                                <li><a href='https://github.com/treasure-sky'>Jinho</a></li>
                                <li><a href='https://github.com/chamjoeun0111'>Taewoong</a></li>
                                <li><a href='https://github.com/ryudain05'>Dain</a></li>
                                <li><a href='https://github.com/yeahzee0421'>Yeji</a></li>
                            </ul>
                        </div>
                        <div className='footer-col'>
                            <h4>Follow us</h4>
                            <div className='social-links'>
                                <a href='https://www.instagram.com/heo_wooong/'><i className='fab fa-instagram-heo'><FaInstagram/></i></a>
                                <a href='https://www.instagram.com/binary__h/'><i className='fab fa-instagram-jin'><FaInstagram/></i></a>
                                <a href='https://www.instagram.com/ryudxin/'><i className='fab fa-instagram-ryu'><FaInstagram/></i></a>
                                <a href='https://www.instagram.com/yeahzxyy/'><i className='fab fa-instagram-ye'><FaInstagram/></i></a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        
    )
}

export default Footer;