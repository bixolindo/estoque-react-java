import { TypeButton } from '../../enum/type-button';
import {
  CustomPrimaryButton,
  CustomSecundaryButton
} from './styles';

interface Props {
  onPress?: (event: React.MouseEvent<HTMLButtonElement, MouseEvent>) => void;
  title: string;
  accessibilityLabel: string;
  disabled: boolean;
  type: TypeButton;
}

export const CustomButton = ({ onPress, title, accessibilityLabel, disabled, type }: Props) => {

  const ButtonComponent = type === TypeButton.PRIMARY ? CustomPrimaryButton : CustomSecundaryButton

  return (
    <ButtonComponent
      onClick={onPress}
      aria-label={accessibilityLabel}
      disabled={disabled}
    >
      {title}
    </ButtonComponent>

  );
}

export default CustomButton;