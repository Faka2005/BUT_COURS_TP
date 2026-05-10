const key = 'XXX'
const baseURL = 'https://api.themoviedb.org/3'
const imgURL = 'https://image.tmdb.org/t/p/w1280'

const movieDAO = {
    getPopulars : async (page=1) => {
        const suffix = `/movie/popular?api_key=${key}&language=en-US&page=${page}`
        const res  = await fetch(baseURL+suffix)
        const data = await res.json()
        return data
    },
    find : async (term, page=1) =>
    {
        const suffix = `/search/movie?api_key=${key}&language=en-US&query=${term}&page=${page}&include_adult=false`
        const res = await fetch(baseURL + suffix)
        const data = await res.json()
        return data
    }
}
//TODO

const root = ReactDOM.createRoot(document.querySelector('#app_container'));
//TODO