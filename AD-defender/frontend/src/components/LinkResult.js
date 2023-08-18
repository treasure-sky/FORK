import React, {useState, useEffect} from "react";
import '../styles/ResultBody.scss';

const resultCom = () => {
    return (
        <h1 style={{
            color: "white",
            fontSize: '40px'
        }}>이 게시물은 <a style={{
            color: "red"
        }}>광고입니다.</a></h1>
    )
}

const resultNotCom = () => {
    return (
        <h1 style={{
            color: "white",
            fontSize: '40px'
        }}>이 게시물은 <a style={{
            color: "green"
        }}>광고가 아닙니다.</a></h1>
    )
}

const LinkResult = (props) => {
    console.log(props.isCommercial);
    return (
        <div>
            {props.isCommercial ? resultCom() : resultNotCom()}
        </div>
    );
}

export default LinkResult;