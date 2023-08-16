import '../styles/Header.scss';
import React from 'react';
import { Link } from 'react-router-dom';

function Header(props){
    return(
        <div className='header'>
            <div className='header-logo'>
                <h1>ForK.</h1>
            </div>
        {/* <Link to="/"><img className='logo-img' alt='logo-img' src='image/app-logo-img-color.png'/></Link> */}
                <nav>
                    <ul>
                        <li><a>Our vision</a></li>
                        <li><a>About us</a></li>
                    </ul>
                </nav>
    </div>
    )
}

export default Header;