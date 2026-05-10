
function Hello({toWhat}) {
    return <div> Hello {toWhat}</div>
}

const root = ReactDOM.createRoot(document.querySelector('#app_container'));
root.render(
    <div>
    <Hello toWhat={'world'}/>
        <Hello toWhat={'jojo'}/>
        <Hello toWhat={'en CM'}/>
    </div>)
