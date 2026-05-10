//spécifique à babel
const { useState, useEffect } = React
const formatDate = (date) => date.toLocaleDateString();

const Clock = () =>  {
    const [date,  setDate] = useState(new Date())
    const tick= () =>  {setDate(new Date())}
    const timer = (duration) => setInterval(()=>tick(),duration)

    const timerID = useEffect(() => {
        const timerID = timer(1000)

        return () => clearInterval(timerID)
    }, []);

   return (
            <div>
                <h1>Hello, world!</h1>
                <h2>It is {date.toLocaleTimeString()}.</h2>
            </div>)

}



const root = ReactDOM.createRoot(document.querySelector('#app_container'));
root.render(
    <Clock
    />)



