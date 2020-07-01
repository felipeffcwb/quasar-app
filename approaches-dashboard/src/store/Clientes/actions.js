import { http } from 'boot/axios'
import { Loading } from 'quasar'
import { notifySucces, notifyError } from '../../exceptions/errors.custom'

const addClientes = ({ dispatch }, payload) => {
  debugger
  Loading.show({
    delay: 400 // ms
  })
  http.post('cliente/add/cliente', payload)
    .then(response => {
      debugger
      Loading.hide()
      notifySucces(response.status)
      dispatch('getCliente')
    })
    .catch(error => {
      debugger
      console.log(error.message)
      Loading.hide()
      notifyError(error.message)
    })
}

const getCliente = ({ commit }) => {
  debugger
  Loading.show({
    delay: 400 // ms
  })
  http.get('cliente/list')
    .then(response => {
      debugger
      Loading.hide()
      commit('SET_CLIENTES', { response })
    })
    .catch(error => {
      debugger
      console.log(error.message)
      Loading.hide()
    })
}

export default {
  addClientes,
  getCliente
}
