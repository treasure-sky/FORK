import { useState } from 'react';
import {Link} from 'react-router-dom';
import {BiSearchAlt} from 'react-icons/bi';
import './LinkInsert.scss';

const LinkInsert = () => {
    const [link, setLink] = useState('');
    const onChange = e => setLink(e.target.value);

    const onClick = () => {
        // alert(link+':');
        setLink("");
    }

    const onKeyDown = e =>{
        if(e.key === 'Enter'){
            onClick();
        }
    }

    // const onChange = useCallback(e =>{
    //     setValue(e.target.value);
    // }, []);

    // const onSubmit = useCallback(
    //     e => {
    //         onInsert(value);
    //         setValue('');
    //         e.preventDefault();
    //     }
    // )

    return(
        <div className='insertWrap'>
            <form className='LinkInsert'>
                <input
                type='text'
                name='link'
                placeholder='링크를 입력하세요.'
                value={link}
                onChange={onChange}
                onKeyDown={onKeyDown}/>
                <Link to="/result">
                    <button onClick={onClick} type='submit'>
                    <BiSearchAlt/>
                </button></Link>
            </form>
        </div>
    )
}

export default LinkInsert;
