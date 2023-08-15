import React, {useState, useEffect} from "react";
import styled from "styled-components";
import HeartFill from "../assets/heart_fill.png";
import HeartOutline from "../assets/heart_outline.png";

//좋아요 기능 있으면 어떨까 하고 슬쩍 넣어봄 
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