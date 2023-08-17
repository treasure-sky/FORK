import Header from '../components/Header';
import Footer from '../components/Footer';
import ResultBody from '../components/ResultBody';
import "../styles/ResultPage.scss";

const Result = (props) => {
    return (
        <div className='Result'>
            <Header/>
            <div className='body'><ResultBody/></div>
            <div className='footer'><Footer/></div>
            {/* <LinkInsert/> */}
        </div>
    )
}

export default Result;