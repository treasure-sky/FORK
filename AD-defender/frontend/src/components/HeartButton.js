import React, {useState, useEffect} from "react";
import styled from "styled-components";
import HeartFill from "../assets/heart_fill.png";
import HeartOutline from "../assets/heart_outline.png";
// import {AiFillHeart} from 'react-icons/ai';
// import {AiOutlineHeart} from 'react-icons/ai';

const Heart = styled.img`
    width: 40px
`;

const HeartButton = ({like, onClick}) => {
    return (
        <Heart src={like?HeartFill:HeartOutline}
        onClick={onClick} />
    )
}

export default HeartButton;