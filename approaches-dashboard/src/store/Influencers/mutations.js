const SET_INFLUENCERS = (state, payload) => {
  debugger
  state.influencers = payload.response.data
}

export default {
  SET_INFLUENCERS
}
