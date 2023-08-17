import Header from '../components/Header';
import Footer from '../components/Footer';
import BodyCopy from '../components/Body';
import '../styles/Main.scss';


const Main = (props) => {
    return (
        <section className='MainPage'>
            <Header/>
            <div className='body'><BodyCopy/></div>
            <div className='footer'><Footer/></div>
            {/* <LinkInsert/> */}
            
        </section>
    )
}

export default Main;