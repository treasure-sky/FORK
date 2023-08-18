import Header from '../components/Header';
import Footer from '../components/Footer';
import Body from '../components/Body';
import '../styles/Main.scss';


const Main = (props) => {
    return (
        <section className='MainPage'>
            <Header/>
            <div className='body'><Body/></div>
            <div className='footer'><Footer/></div>
            {/* <LinkInsert/> */}
        </section>
    )
}

export default Main;