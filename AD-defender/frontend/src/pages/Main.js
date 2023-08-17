import Header from '../components/Header';
import Footer from '../components/Footer';
import BodyCopy from '../components/Body';
import '../styles/Main.scss'

const Main = (props) => {
    return (
        <div className='MainPage'>
            <Header/>
            <div className='body'><BodyCopy/></div>
            <div className='footer'><Footer/></div>
            {/* <LinkInsert/> */}
            
        </div>
    )
}

export default Main;