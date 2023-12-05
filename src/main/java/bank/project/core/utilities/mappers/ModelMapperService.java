package bank.project.core.utilities.mappers;

import org.modelmapper.ModelMapper;

public interface ModelMapperService {
	ModelMapper forResponses();

	ModelMapper forRequests();
}
