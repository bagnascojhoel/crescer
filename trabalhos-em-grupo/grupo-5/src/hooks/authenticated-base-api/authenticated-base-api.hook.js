import { useMemo } from 'react';
import { useGlobalUser } from '../../context';
import { useBaseAPI } from '../';

export function useAuthenticatedBaseAPI(context) {
  const [{ token }] = useGlobalUser();
  const baseAPI = useBaseAPI(context, { authorization: token });

  return useMemo(() => baseAPI, []);
}
