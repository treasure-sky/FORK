import '../styles/Body.scss';
import LinkInsert from './LinkInsert';

const Main = ({children}) =>{
    return(
        <div className='body'>
            <div className='app-title'>
                {/*<h3>Free website for verifying advertisements</h3>*/}
                <h1>FIND OUT REAL</h1>
                <h1>KNOWLEDGE</h1>
            </div>
            <div className='app-introd'>
                <h3>광고성 글 판별을 위한 무료 웹사이트 </h3>
                <h3>궁금한 게시물을 자유롭게 검색해보세요.</h3>
            </div>
            <div className='content'>
            <LinkInsert/>
            </div>

    </div>
    )
}

export default Main;