const Hello = ({toWhat}) => <div> Hello {toWhat}</div>

const root = ReactDOM.createRoot(document.querySelector('#app_container'));
root.render(
    <div>
        <Hello toWhat={'world'}/>
        <Hello toWhat={'à toi'}/>
    </div>
);
