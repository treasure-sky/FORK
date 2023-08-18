import Header from '../components/Header';
import Footer from '../components/Footer';
import '../styles/bi.scss';
import {React} from "react";
const bi = (props) => {
    return(
        <section className='bi'>
            <Header/>
            <div className='wrapper'>
                <div className='container'>
                    <div className='bi-title'>
                        <h1>광고만 골라서,<br/>ForK: 포크</h1>
                    </div>
                    <hr/>
                    <div className='bi-in-vision'>
                        <img src='image/vision02.png'/>
                        <h2>Our Vision</h2>
                        <h3>광고성 글의 명확한 구분을 위한 웹사이트입니다. <br/>
                            인터넷 상에서 효과적인 정보 습득 방법을 제공함으로써 <br/>
                            사용자의 안전한 디지털 환경 조성에 기여합니다. </h3>
                    </div>
                    <div className='bi-content'>

                    </div>
                </div>
            </div>
            <Footer/>
        </section>

    )
}

export default bi;