import Header from '../components/Header';
import Footer from '../components/Footer';
import Body from '../components/Body';
import LinkInsert from '../components/LinkInsert';
import '../styles/Main.scss'

const Main = (props) => {
    return (
        <div className='MainPage'>
            <Header/>
            <Body/>
            <LinkInsert/>
            <Footer/>
        </div>
    )
}

export default Main;