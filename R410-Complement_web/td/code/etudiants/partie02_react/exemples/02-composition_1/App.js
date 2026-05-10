class Hello extends React.Component {
  render() {
    return <div> Hello {this.props.toWhat}</div>
  }
}

const root = ReactDOM.createRoot(document.querySelector('#app_container'));
root.render(
    <div>
    <Hello toWhat={'world'}/>
    <Hello toWhat={'à toi'}/>
    </div>
);