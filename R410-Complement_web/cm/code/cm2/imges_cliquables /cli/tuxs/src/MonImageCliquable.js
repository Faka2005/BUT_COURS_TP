export default function MonImageCliquable(props) {
    const doOnclick = (e) => {
        props.update(props.src)
    }
    return <img src={"../assets/images/"+props.src+"_tux.png"} alt="" onClick={doOnclick} />
}
