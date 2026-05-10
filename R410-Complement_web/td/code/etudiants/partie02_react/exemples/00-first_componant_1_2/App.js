const Hello= (props) => {
    return React
        .createElement('div', null, `Hello ${props.toWhat}`);

}

const root = ReactDOM
    .createRoot(document.querySelector('#app_container'));
root.render(React.createElement(Hello, {toWhat: 'Jojo'}, null));
