import { Fragment } from 'react';
import { ReactDOM } from 'react';
import styles from './Modal.module.css';

function Backdrop(props){
    return <div className={styles.backdrop} onClick={props.onClose}/>
};

function ModalOverlay(props){
    return (
        <div className={styles.modal}>
            <div className={styles.content}>{props.children}</div>
        </div>
    )
};


function Modal(props){
    const portalElement = document.getElementById('overlays');

    return (
    <Fragment>
        {ReactDOM.createPortal(<Backdrop onClose={props.onClose} />, portalElement)}
        {ReactDOM.createPortal(<ModalOverlay>{props.children}</ModalOverlay>, portalElement)}
    </Fragment>
    );
};

export default Modal;