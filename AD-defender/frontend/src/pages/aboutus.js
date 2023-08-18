import Header from '../components/Header';
import Footer from '../components/Footer';
import Body from '../components/AboutBody';
import '../styles/aboutus.scss'
const aboutus = (props) => {
    return(
        <section className='About'>
            <Header/>
            <div className='body'><Body/></div>
            <Footer/>
        </section>
    )
}

export default aboutus;