import React from 'react'
import {connect} from 'react-redux'
import {Grid, PageHeader, Table, Button} from 'react-bootstrap'


class GamesListView extends React.Component {
  render() {
    const {
      games
    } = this.props

    return (
      <Grid>
        <PageHeader>Lista Gier<br/>
          <small>Poniżej znajdziesz listę dostępnych u nas pozycji</small>
        </PageHeader>

        <Table striped>
          <thead>
          <tr>
            <th>Id</th>
            <th>Nazwa gry</th>
            <th>Liczba graczy</th>
          </tr>
          </thead>
          <tbody>
          {
            games.map(
              game => (
                <tr key={game.id}>
                  <td>{game.id}</td>
                  <td>{game.name}</td>
                  <td>{game.players}</td>
                </tr>
              )
            )
          }
          </tbody>
        </Table>
      </Grid>
    )
  }
}

export default connect(
  state => ({
    games: state.games
  }),
  dispatch => ({})
)(GamesListView)