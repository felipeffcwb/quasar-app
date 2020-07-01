import { Notify } from 'quasar'

const notifySucces = (status) => {
  Notify.create({
    type: 'positive',
    message: 'Sucesso!'
  })
}

const notifyError = (status) => {
  Notify.create({
    type: 'negative',
    message: status
  })
}

export {
  notifySucces,
  notifyError
}
