const { useState} = React

const WarningBanner = ({warn})=>
    (!warn) ? null :
           <div className="warning">
                Attention !
           </div>


const Page = () =>  {
    const [showWarning, toggle] = useState(true)
    const handleToggleClick = () => {
        toggle(!showWarning)
    }
    return (
            <div>
                <WarningBanner warn={showWarning} />
                <button onClick={handleToggleClick}>
                    {showWarning ? 'Masquer' : 'Afficher'}
                </button>
            </div>
        );
}
const root = ReactDOM.createRoot(document.querySelector('#app_container'));
root.render(<Page />);

