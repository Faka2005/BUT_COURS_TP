class Hello extends React.Component {
  render() {
    return React
        .createElement('div', null, `Hello ${this.props.toWhat}`);
  }
}

const root = ReactDOM
    .createRoot(document.querySelector('#app_container'));
root.render(React.createElement(Hello, {toWhat: 'Jojo'}, null));