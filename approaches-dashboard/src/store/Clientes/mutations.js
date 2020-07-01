const SET_CLIENTES = (state, payload) => {
  debugger
  state.clientes = payload.response.data
}

export default {
  SET_CLIENTES
}
