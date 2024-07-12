import styled from 'styled-components';


export const DashboardContainer = styled.div`
  width: 100%;
  height: 100%;

  display: flex;
  align-items: center;
  justify-content: center;

  padding: ${props => props.theme.spacing_squish_md};
`

export const FilterSection = styled.section`
  width: 100;
  /* border-bottom: ${props => props.theme.stroke_100} solid ${props => props.theme.color_neutral_medium_02}; */

  display: flex;

  justify-content: space-between;
`

export const Divisor = styled.hr`
  width: 100%;
  margin: ${props => props.theme.spacing_xs} 0 ;
  stroke: ${props => props.theme.stroke_100};
`