import { useState } from 'react';
import '../styles/LinkInsert.scss';
import axios from "axios";
import {BiSearchAlt} from "react-icons/bi";
import { useNavigate } from 'react-router-dom';

const LinkInsert = () => {
    const [link, setLink] = useState('');
    const navigate = useNavigate();
    const onChange = e => setLink(e.target.value);

    const onKeyDown = e => {
        if (e.key === 'Enter') {
            e.preventDefault();
            handleSubmit(e);
        }
    };

    const handleSubmit = async(e) => {
        e.preventDefault();
        try {
            const response = await axios.post("/result", {
                link,
            });
            console.log(response.data);
            navigate("/result",  { state: { chatResponse: response.data } });
        } catch(error) {
            console.error("저장실패", error);
        }
    };

    return (
        <div className='insertWrap'>
            <form className='LinkInsert' onSubmit={handleSubmit}>
                <input
                    type='text'
                    name='link'
                    placeholder='링크를 입력하세요.'
                    value={link}
                    onChange={onChange}
                    onKeyDown={onKeyDown}
                />
                <button type='submit'>
                    <BiSearchAlt/>
                </button>
            </form>
        </div>
    );
};

export default LinkInsert;
