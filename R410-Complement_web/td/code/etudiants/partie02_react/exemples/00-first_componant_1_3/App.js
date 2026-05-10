const Hello= ({toWhat}) => {
    return React
        .createElement('div', null, `Hello ${toWhat}`);

}

const root = ReactDOM
    .createRoot(document.querySelector('#app_container'));
root.render(React.createElement(Hello, {toWhat: 'Jojo'}, null));
