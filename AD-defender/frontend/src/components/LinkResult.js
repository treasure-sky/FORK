import React, {useState, useEffect} from "react";
import '../styles/ResultBody.scss';

const resultCom = () => {
    return (
        <h1 style={{color:"white"}}>This post is <a>Commercial</a></h1>
    )
}

const resultNotCom = () => {
    return (
        <h1 style={{color:"white"}}>This post is <a>Not Commercial</a></h1>
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