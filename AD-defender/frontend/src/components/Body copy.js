import '../styles/Body copy.scss';
import LinkInsert from '../components/LinkInsert copy';

const Main = ({children}) =>{
    return(
        <div className='body'>
            <div className='app-title'>
                <h1>FIND OUR REAL</h1>
                <h1>KNOWLEDGE</h1>
            </div>
            <div className='app-introd'>
                <h3>Free website for verifying advertisements, Find Out Real Knowledge</h3>
                <h3>광고성 글 판별을 위한 무료 웹사이트. 궁금한 포스트를 자유롭게 검색해보세요.</h3>
            </div>
            <div className='content'>
            <LinkInsert/>
            </div>

    </div>
    )
}

export default Main;