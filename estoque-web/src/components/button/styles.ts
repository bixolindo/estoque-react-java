import styled from 'styled-components';
import { device } from '../../enum/devices';

export const CustomPrimaryButton = styled.button`
  padding: ${props => props.theme.spacing_squish_lg};
  background-color: ${props => props.theme.color_action_medium};
  border-radius: ${props => props.theme.radius_300};

  color: ${props => props.theme.color_neutral_lightest};
  font-weight: ${props => props.theme.font_weight_regular};
  font-size: ${props => props.theme.font_size_sm};
  line-height: ${props => props.theme.line_height_tightest};

  transition: background-color 0.3s;
  cursor: pointer;
  border: none;

  @media ${device.mobileM} { 
    padding: ${props => props.theme.spacing_squish_sm};
    font-size: ${props => props.theme.font_size_base};
  }

  @media ${device.tablet} {
    padding: ${props => props.theme.spacing_squish_md};
    font-size: ${props => props.theme.font_size_xs};
  }

  @media ${device.laptop} {
    padding: ${props => props.theme.spacing_squish_lg};
    font-size: ${props => props.theme.font_size_sm};
  }

  &:hover:enabled {
    background-color: ${props => props.theme.color_action_light};
  }

  &:active{
    background-color: ${props => props.theme.color_action_dark};
  }

  &:disabled {
    background-color: ${props => props.theme.color_action_lightest};
    cursor: not-allowed;
  }

`;

export const CustomSecundaryButton = styled.button`

  padding: ${props => props.theme.spacing_squish_lg};
  background-color: ${props => props.theme.color_transparent};

  color: ${props => props.theme.color_action_medium};
  font-weight: ${props => props.theme.font_weight_regular};
  font-size: ${props => props.theme.font_size_sm};
  line-height: ${props => props.theme.line_height_tightest};
  
  border: ${props => props.theme.stroke_100} solid ${props => props.theme.color_action_medium};
  border-radius: ${props => props.theme.radius_300};

  transition: background-color 0.3s;
  cursor: pointer;

  @media ${device.mobileM} { 
    padding: ${props => props.theme.spacing_squish_sm};
    font-size: ${props => props.theme.font_size_base};
  }

  @media ${device.tablet} {
    padding: ${props => props.theme.spacing_squish_md};
    font-size: ${props => props.theme.font_size_xs};
  }

  @media ${device.laptop} {
    padding: ${props => props.theme.spacing_squish_lg};
    font-size: ${props => props.theme.font_size_sm};
  }

  &:hover:enabled {
    background-color: ${props => props.theme.color_action_medium};
    color: ${props => props.theme.color_neutral_light};
  }

  &:disabled {
    border: none;
    color:  ${props => props.theme.color_neutral_lightest};;
    background-color: ${props => props.theme.color_action_lightest};
    cursor: not-allowed;
  }
`;