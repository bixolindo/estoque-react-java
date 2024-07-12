import { TextField } from '@mui/material';
import styled from 'styled-components';
import theme from '../../theme'


export const StyledInput = styled(TextField)({
  '& label.Mui-focused': {
    color: theme.color_action_medium,
  },
  '& .MuiInputBase-input': {
    borderRadius: theme.radius_200,
    backgroundColor: theme.color_neutral_lightest,
    border: `${theme.stroke_100} solid ${theme.color_neutral_medium_04}`,
    fontSize: theme.font_size_xs,
    width: 'auto',
    padding: theme.spacing_xxxs,
    fontWeight: theme.font_weight_regular,
    lineHeight: theme.line_height_medium,
    transition: 'background-color 0.3s,  border-color 0.3s,  box-shadow 0.3s, ',
    '&:focus': {
      borderColor: theme.color_action_medium,
    },
    '&:disabled': {
      border: `${theme.stroke_100} solid ${theme.color_neutral_medium_04}`,
      color: theme.color_neutral_medium_04,
      cursor: 'not-allowed',
    }
  },
  '& .MuiInput-underline:after': {
    borderBottomColor: '#B2BAC2',
  },
  '& .MuiOutlinedInput-root': {
    '& fieldset': {
      borderColor: '#E0E3E7',
    },
    '&:hover:enabled fieldset': {
      borderColor: theme.color_action_medium,
    },
    '&.Mui-focused fieldset': {
      borderColor: theme.color_action_medium,
    },
  },
  '& input:valid + fieldset': {
    borderColor: theme.color_alert_success,
  },
  '& input:invalid + fieldset': {
    borderColor: theme.color_alert_error,
  },
});