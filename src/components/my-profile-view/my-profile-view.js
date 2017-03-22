import React from 'react'
import {Link} from 'react-router'
import {connect} from 'react-redux'
import {Grid, Row, Col, Panel, PageHeader, Image} from 'react-bootstrap'
import {Tabs, Tab} from 'react-bootstrap-tabs'

export default connect(
  state => ({
    user: state.user
  })
)(
  class MyProfileView extends React.Component {
    render() {
      const {
        user
      } = this.props

      const currentUser =
        user.data ? user.data : null

      if (currentUser === null) {
        return <p>Waiting for users data...</p>
      }

      return (
        <Grid>
          <PageHeader>Profil użytkownika<br/>
          </PageHeader>
          <Row>
            <Col xs={12} md={4} sm={6}>
              <div key={currentUser.id}>

              </div>
            </Col>

            <Col xs={12} sm={6} md={8}>
              <div key={currentUser.id}>
                <h3>{currentUser.username}</h3>
                <p>About</p>
              </div>
            </Col>
          </Row>
        </Grid>
      )
    }
  }
)