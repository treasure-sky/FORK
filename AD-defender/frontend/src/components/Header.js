import '../styles/Header.scss';
import React from 'react';
import { Link } from 'react-router-dom';

function Header(props){
    return(
        <div className='header'>
            {/* <div className='header-logo'>
                <h1>ForK.</h1>
            </div> */}
        <Link to="/"><img className='logo-img' alt='logo-img' src='image/app-logo-img-color.png'/></Link>
                <nav>
                    <ul>
                    <Link to="/bi"><li><a>사이트 소개</a></li></Link>
                    <Link to="/aboutus"><li><a>팀원 소개</a></li></Link>
                    </ul>
                </nav>
                
    </div>
    )
}

export default Header;