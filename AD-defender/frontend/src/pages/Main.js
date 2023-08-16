import Header from '../components/Header';
import Footer from '../components/Footer';
import BodyCopy from '../components/Body copy';
import '../styles/Main.scss'

const Main = (props) => {
    return (
        <div className='MainPage'>
            <div className='header'><Header/></div>
            <div className='body'><BodyCopy/></div>
            <div className='footer'><Footer/></div>
            {/* <LinkInsert/> */}
            
        </div>
    )
}

export default Main;