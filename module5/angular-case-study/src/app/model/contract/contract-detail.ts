import {AttachService} from './attach-service';
import {Contract} from './contract';

export interface ContractDetail {
  id?: number;
  quantity?: number;
  attachService?: AttachService;
  contract?: Contract;
}
